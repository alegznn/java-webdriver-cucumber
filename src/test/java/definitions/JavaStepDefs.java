package definitions;

import cucumber.api.java.en.Given;

import javax.servlet.http.HttpSessionEvent;

public class JavaStepDefs {
    @Given("I print {string} in console")
    public void iPrintInConsole(String arg0) {
       System.out.println(arg0);
       System.out.println("I am cool!");
    }


    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println(str1+" "+str2);
        System.out.println(str1.toLowerCase());
        System.out.println(str2.toUpperCase());
        String firstName="Alex";
        String lastName="Yablontsev";
        String favColor="red";
        System.out.println(firstName+" "+lastName+" likes "+favColor+" color");
        System.out.println(lastName.length());
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1==str2);
        System.out.println(lastName.contains("tsev"));

    }


    @Given("I run operators with {int} and {int}")
    public void iRunOperatorsWithAnd(int num1, int num2) {
        System.out.println(num1);
        System.out.println(num2);
        /*if (num1<num2){
            System.out.println("First number is less than Second  number");
        }else{
            System.out.println("First number is greater than Second  number");
        }*/
        int sum=num1+num2;
        System.out.println(sum);
        int diff=num1-num2;
        System.out.println(diff);
    }

    @Given("I print url for {string} page")
    public void iPrintUrlForPage(String site) {
        if (site.equalsIgnoreCase("google")){
            System.out.println("https://www.google.com/");
        }else if (site.equalsIgnoreCase("Get a Quote")){
            System.out.println("http://skryabin.com/webdriver/html/quote.html");
        }else {
            System.out.println("Unknown site");
        }
    }

    @Given("I print arrays")
    public void iPrintArrays() {
        String[] groceryList={"cheese","cream","chiken","ketchup","eggs","bread"};
        //System.out.println(groceryList);//will not print any values, need to use index
        //System.out.println(groceryList[0]);
        //System.out.println(groceryList[1]);
        //for (int i=0;i<groceryList.length;i++){
         //   System.out.println(groceryList[i]);
        //}
        for (String element:groceryList){
            System.out.println(element);
        }
    }

    @Given("I print numeric arrays")
    public void iPrintNumericArrays() {
        int[] years={1999,2013,2015,2017};
        for (int element:years){
            System.out.println(element);
        }
    }

    @Given("I compare strings {string} and {string}")
    public void iCompareStringsAnd(String str1, String str2) {
        if(str1.equals(str2)){
            System.out.println("Strings match");
        } else if(str2.contains(str1)){
            System.out.println("Strings partially match");
        } else {
            System.out.println("Strings do not match");
        }
    }
}
