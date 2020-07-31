import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        String path1="/guest/signup";
        String path2="/guest";
        String path3="/helpAdmin";
        String path4="/admin";

        Class AdminControllerclass= AdminController.class;
        Annotation[] AdminControllerclassanot=AdminControllerclass.getAnnotations();
        AdminPath adminp=(AdminPath)AdminControllerclassanot[0];
        ///////////////////////
        Class AdminHelpControllerclass=AdminHelpController.class;
        Annotation[] AdminHelpControllerclassanot=AdminHelpControllerclass.getAnnotations();
        AdminPath adminHelpp=(AdminPath)AdminHelpControllerclassanot[0];
        if(path4.equals(adminp.value())){
            AdminController adminController=new AdminController();
        }else if(path3.equals(adminHelpp)){
            AdminHelpController adminHelpController=new AdminHelpController();

        }else{}

        /////////////////////////metod
        Class aClass=GuestController.class;
        Method[] methods=aClass.getMethods();
        for (Method method:methods)
        {
            Annotation[] annotation=method.getAnnotations();
            for (Annotation annotation1:annotation){
                if(annotation1 instanceof GuestPath)
                {
                    GuestPath guestPath=(GuestPath)annotation1;
                    System.out.println(guestPath.value());

                }else{}



            }
        }
    }
}
