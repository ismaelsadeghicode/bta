@AdminPath(value = "/admin")
public class AdminController {
    AdminController(){
        System.out.println("AdminController constractor iscall");
    }
    public void PrintPath(String path){
        System.out.println("AdminController.print()");
    }

    }
