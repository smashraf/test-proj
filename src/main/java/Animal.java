
public class Animal {
    
    private Integer size;
    
    private Integer height;

    public Animal(Integer size, Integer height) {
        this.size = size;
        this.height = height;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + height;
        result = prime * result + size;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (height != other.height)
            return false;
        if (size != other.size)
            return false;
        return true;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "size : " + size + " height : " + height;
    }
    

}
