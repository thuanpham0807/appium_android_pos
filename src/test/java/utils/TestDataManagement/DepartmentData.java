package utils.TestDataManagement;
import utils.TestDataManagement.GeneralData;

public class DepartmentData {
    private String name;
    private String secondName;
    private int index;
    private String parentIndex;
    private String price;
    private String maxPrice;
    private String vat1;
    private String vat2;
    private String vat3;
    private String printer;
    private String secondPrinter;

    public int getIndex(){return this.index;}
    public void setIndex (int value){this.index = value;}

    public String getName(){return this.name;}
    public void setName(String value){this.name = value;}

    public String getSecondName(){return this.secondName;}
    public void setSecondName(String value){this.secondName = value;}

    public String getPrice(){return this.price;}
    public void setPrice(String value){this.price = value;}

    public String getMaxPrice(){return this.maxPrice;}
    public void setMaxPrice(String value){this.maxPrice = value;}

    //sample test real data from file db_20180814_054722_40603200.xls
    // Departments (categories)
    public static final String starter	=	"Starter";
    public static final String 	mainCourses	=	"Main Courses";
    public static final String 	secondCourses	=	"Second Courses";
    public static final String 	fish	=	"Fish";
    public static final String 	pizza	=	"Pizza"	;
    public static final String 	dessert	=	"Dessert";
    public static final String 	drink	=	"Drink"	;
    public static final String 	wine	=	"Wine"	;
    public static final String 	beer	=	"Beer"	;

    public static final String	STARTER_Rustico	=	"Rustico"	;
    public static final String	STARTER_bruschetta	=	"Bruschetta"	;
    public static final String	STARTER_puttanescaPizzinis	=	"Puttanesca Pizzinis"	;
    public static final String	MAIN_COURSES_mushroomRice	=	"Mushroom Rice"	;
    public static final String	STARTER_fishKoftas	=	"Fish Koftas"	;
    public static final String	MAIN_COURSES_ravioliWithRicotta	=	"Ravioli with ricotta"	;
    public static final String	MAIN_COURSES_tagliatelleWithWildFennel	=	"Tagliatelle with wild fennel"	;
    public static final String	SECOND_COURSES_porkChopAuGratin	=	"Pork chop au gratin"	;
    public static final String	SECOND_COURSES_GrilledSteak	=	"Grilled steak"	;
    public static final String	SECOND_COURSES_LambWithRosemary	=	"Lamb with rosemary"	;
    public static final String	SECOND_COURSES_MilaneseCutlet	=	"Milanese cutlet"	;
    public static final String	SECOND_COURSES_Mixedroast	=	"Mixed roast"	;
    public static final String	SECOND_COURSES_Rabbitwithvegetables	=	"Rabbit with vegetables"	;
    public static final String	SECOND_COURSES_Stewedpork	=	"Stewed pork"	;
    public static final String	SECOND_COURSES_Boiledmeat	=	"Boiled meat"	;
    public static final String	SECOND_COURSES_Tripe	=	"Tripe	"	;
    public static final String	SECOND_COURSES_Friedsausagewithblakolives	=	"Fried sausage with blak olives"	;
    public static final String	STARTER_Chickenwings	=	"Chicken wings"	;
    public static final String	STARTER_KingPrawn	=	"King Prawn"	;
    public static final String	SECOND_COURSES_ChargrilledLamb	=	"Chargrilled Lamb"	;
    public static final String	STARTER_MixedSalad	=	"Mixed Salad"	;
    public static final String	STARTER_RoastPotatoes	=	"Roast Potatoes"	;
    public static final String	STARTER_BakedPasta	=	"Baked Pasta"	;
    public static final String	MAIN_COURSES_BuckwheatTagliatelle	=	"Buckwheat Tagliatelle"	;
    public static final String	MAIN_COURSES_Cannelloni	=	"Cannelloni"	;
    public static final String	MAIN_COURSES_Dumplings	=	"Dumplings"	;
    public static final String	MAIN_COURSES_CheeseCrepes	=	"Cheese Crepes"	;
    public static final String	SECOND_COURSES_BeefRolls	=	"Beef Rolls"	;
    public static final String	SECOND_COURSES_ChickenBreast	=	"Chicken Breast"	;
    public static final String	SECOND_COURSES_ChickenCroquettes	=	"Chicken Croquettes"	;
    public static final String	SECOND_COURSES_CurryVealStew	=	"Curry Veal Stew"	;
    public static final String	SECOND_COURSES_EscalopeBolognese	=	"Escalope Bolognese"	;
    public static final String	SECOND_COURSES_EscalopeCordon	=	"Escalope Cordon"	;
    public static final String	SECOND_COURSES_Filletofbeef	=	"Fillet of beef"	;
    public static final String	SECOND_COURSES_GrilledSirloinSteak	=	"Grilled Sirloin Steak"	;
    public static final String	SECOND_COURSES_LambStew	=	"Lamb Stew"	;
    public static final String	FISH_SeaBass	=	"Sea Bass"	;
    public static final String	FISH_CarpetShells	=	"Carpet Shells"	;
    public static final String	FISH_Crab	=	"Crab"	;
    public static final String	FISH_CrabMeat	=	"Crab Meat"	;
    public static final String	FISH_FiletsofSole	=	"Filets of Sole"	;
    public static final String	FISH_FriedSquids	=	"Fried Squids"	;
    public static final String	FISH_GiltheadSeaBream	=	"Gilthead SeaBream"	;
    public static final String	FISH_Lobster	=	"Lobster"	;
    public static final String	PIZZA_PizzaCrudo	=	"Pizza Crudo"	;
    public static final String	PIZZA_Romana	=	"Romana"	;
    public static final String	PIZZA_Siciliana	=	"Siciliana"	;
    public static final String	PIZZA_Diavola	=	"Diavola"	;
    public static final String	PIZZA_Viennese	=	"Viennese"	;
    public static final String	PIZZA_Fresca	=	"Fresca"	;
    public static final String	PIZZA_Ortolana	=	"Ortolana"	;
    public static final String	PIZZA_AsparagieUova	=	"Asparagi e Uova"	;
    public static final String	PIZZA_BracciodiFerro	=	"Braccio di Ferro"	;
    public static final String	PIZZA_Marimonti	=	"Marimonti"	;
    public static final String	PIZZA_Calzone	=	"Calzone"	;
    public static final String	DESSERT_Appleturnover	=	"Apple turnover"	;
    public static final String	DESSERT_ApricotTurnovers	=	"Apricot Turnovers"	;
    public static final String	DESSERT_Cantuccini	=	"Cantuccini"	;
    public static final String	DESSERT_Cenci	=	"Cenci"	;
    public static final String	DESSERT_Chocolatelog	=	"Chocolate log"	;
    public static final String	DESSERT_CremeCaramel	=	"Creme Caramel"	;
    public static final String	DESSERT_Custardprofiteroles	=	"Custard profiteroles"	;
    public static final String	DRINK_AppleJuice	=	"Apple Juice"	;
    public static final String	DRINK_OrangeJuice	=	"Orange Juice"	;
    public static final String	DRINK_blackcoffee	=	"black coffee"	;
    public static final String	DRINK_Brandy	=	"Brandy"	;
    public static final String	DRINK_Cappuccino	=	"Cappuccino"	;
    public static final String	DRINK_Chocolate	=	"Chocolate"	;
    public static final String	DRINK_Cognac	=	"Cognac"	;
    public static final String	BEER_DoubleMaltbeer	=	"Double-Malt beer"	;
    public static final String	BEER_DraughtBeer	=	"Draught Beer"	;
    public static final String	WINE_DrySparklingWine	=	"Dry Sparkling Wine"	;
    public static final String	DRINK_StillWater	=	"Still Water"	;
    public static final String	BEER_Paleale	=	"Pale ale"	;
    public static final String	WINE_WhiteWine	=	"White Wine"	;
    public static final String	DRINK_CocaCola	=	"Coca Cola"	;
    public static final String	DRINK_Fanta	=	"Fanta"	;
    public static final String	DRINK_Sprite	=	"Sprite"	;
    public static final String	BEER_Heineken	=	"Heineken"	;
    public static final String	BEER_Becks	=	"Becks"	;
    public static final String	BEER_Corona	=	"Corona"	;
    public static final String	BEER_Franzizkaner	=	"Franzizkaner"	;
    public static final String	BEER_Carlsberg	=	"Carlsberg"	;
    public static final String	WINE_Argiolas	=	"Argiolas"	;
    public static final String	WINE_ChateaudeMarbuzet	=	"Chateau de Marbuzet"	;
    public static final String	WINE_BrunellodiMontalcino	=	"Brunello di Montalcino"	;
    public static final String	WINE_chateauYonFigeac	=	"Chateau Yon Figeac"	;
    public static final String	WINE_champagneKrugGrande	=	"Champagne Krug Grande"	;
    public static final String	DRINK_averna	=	"Averna"	;
    public static final String	DRINK_cointreau	=	"Cointreau"	;
    public static final String	DRINK_fernetBranca	=	"Fernet Branca"	;
    public static final String	DRINK_chivas	=	"Chivas"	;
    public static final String	DRINK_jackDaniels	=	"Jack Daniels"	;

}