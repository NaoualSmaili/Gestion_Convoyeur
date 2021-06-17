public class MdseObjet {
    int poids;

    public MdseObjet() {
        int Min = 1;
        int Max = 20;

        this.poids = (int) (Math.random() * (Max - Min) + 1);
    }

    public int getPoids() {
        return poids;
    }

}
