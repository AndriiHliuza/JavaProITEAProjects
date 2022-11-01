package lection10.lesson10;

public class CoinRunner {

//    public void doAction(String value) throws CoinTechnicalException {
//        Coin ob = new Coin();
//
//        try {
//            double d = Double.parseDouble(value);
//            ob.setDiameter(d);
//        } catch (NumberFormatException e) {
//            throw new CoinTechnicalException("incorrect symbol in string", e);
//        } catch (CoinLogicException e) {
//            System.err.println(e.getCause());
//        }
//    }

    public void doAction(String value) throws CoinLogicException {
        Coin ob =  new Coin();
        try {
            double d = Double.parseDouble(value);
            ob.setDiameter(d);
        } catch (CoinException e) {
            throw e;
        }
    }
}
