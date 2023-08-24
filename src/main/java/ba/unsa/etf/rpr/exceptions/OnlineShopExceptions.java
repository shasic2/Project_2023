package ba.unsa.etf.rpr.exceptions;

public class OnlineShopExceptions extends Exception{
    public OnlineShopExceptions(String message, Exception reason) {
        super(message, reason);
    }

    public OnlineShopExceptions(String message) {
        super(message);
    }
}
