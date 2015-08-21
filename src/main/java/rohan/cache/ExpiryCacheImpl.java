package rohan.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class ExpiryCacheImpl<K, V> implements ExpiryCache<K, V> {

    // This acts as the cache
    private ConcurrentHashMap<K, V> map = new ConcurrentHashMap<K, V>();

    // This acts as the store of ttl
    private ConcurrentHashMap<K, TtlInfo> ttlMap = new ConcurrentHashMap<K, TtlInfo>();

    @Override
    public void put(K key, V value, int ttl, TimeUnit timeUnit) {
        TtlInfo ttlInfo = new TtlInfo();
        ttlInfo.setTtl(ttl);
        ttlInfo.setTimeUnit(timeUnit);
        ttlInfo.setStartTime(timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS));
        // At the time of put, putting values in both the maps
        synchronized (this) {
            map.put(key, value);
            ttlMap.put(key, ttlInfo);
        }
    }

    @Override
    public V get(K key) {

        TtlInfo ttlInfo;

        Long currTime;

        currTime = System.currentTimeMillis();
        ttlInfo = ttlMap.get(key);

        // Base case when key is not present
        if (null == ttlInfo) {
            return null;
        } else if (ttlInfo.getTimeUnit().convert(currTime, TimeUnit.MILLISECONDS) - ttlInfo.getStartTime() > ttlInfo
                .getTtl()) {
            // ttl has expired, hence removing the record from cache before
            // returning null
            synchronized (this) {
                map.remove(key);
                ttlMap.remove(key);
            }
            return null;
        } else {
            synchronized (this) {
                // To check if some other thread has not removed this guy from
                // cache
                if (null != ttlMap.get(key)) {
                    return map.get(key);
                } else {
                    return null;
                }
            }
        }
    }

}
