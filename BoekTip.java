public class BoekTip {
    private Boek aanbevolenBoek;
    private String reden;
    private boolean geliked;

    public BoekTip(Boek aanbevolenBoek, String reden, boolean geliked) {
        this.aanbevolenBoek = aanbevolenBoek;
        this.reden = reden;
        this.geliked = geliked;
    }

    public Boek getAanbevolenBoek() {
        return aanbevolenBoek;
    }

    public String getReden() {
        return reden;
    }

    public boolean isGeliked() {
        return geliked;
    }
}
