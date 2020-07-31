

public class GuestController {
    @GuestPath(value = "/guest")
    public void products(String path){
        System.out.println(path);
    }
    @GuestPath(value = "/guest/signup")
    public void signup(String path){
        System.out.println(path);
    }
}
