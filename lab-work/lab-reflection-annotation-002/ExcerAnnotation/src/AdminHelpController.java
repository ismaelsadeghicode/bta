@AdminPath(value = "/helpAdmin")
public class AdminHelpController {
    public AdminHelpController() {
        System.out.println("AdminHelpController constractor iscall.");
    }

    public void PrintPath(String path){
        System.out.println("AdminHelpController.print()");
    }
}
