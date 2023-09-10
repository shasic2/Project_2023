package ba.unsa.etf.rpr.exceptions;

public class HealthyShopException  extends  Exception{

public HealthyShopException(String message, Exception reason) {
    super(message, reason);
}

public HealthyShopException(String message) {
    super(message);
}
}
