package opg4;

public class SpiritusToVareAdapter extends Vare {
    private Spiritus spiritus;
    public SpiritusToVareAdapter(Spiritus spiritus) {
        super(0, "");
        this.spiritus = spiritus;
    }

    @Override
    public int getPris() {
        return spiritus.getPrisen();
    }

    @Override
    public void setPris(int pris) {
        spiritus.setPrisen(pris);
    }

    @Override
    public String getNavn() {
        return spiritus.getBetgenelse();
    }

    @Override
    public void setNavn(String navn) {
        spiritus.setBetgenelse(navn);
    }

    @Override
    public double beregnMoms() {
        return spiritus.hentMoms();
    }
}
