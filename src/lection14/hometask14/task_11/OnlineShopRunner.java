package lection14.hometask14.task_11;

public class OnlineShopRunner {
    public static void main(String[] args) {
        OnlineShop onlineShop = new OnlineShop();
        onlineShop.addProductToOnlineShopCatalog("Milk", 300, 3);
        onlineShop.addProductToOnlineShopCatalog("Bread", 200, 2);
        onlineShop.addProductToOnlineShopCatalog("Apple", 400, 4);
        onlineShop.addProductToOnlineShopCatalog("Rice", 500, 1);
        onlineShop.printProductsFromCatalog(OnlineShop.TypeOfSorting.PRICE, false);
    }
}
