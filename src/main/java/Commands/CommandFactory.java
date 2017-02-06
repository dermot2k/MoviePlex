
package Commands;

/**
 * @author Dermot
 * @author Jimmy
 */
public class CommandFactory {

    /**
     *
     * @param action
     * @return method by string
     */
    public Command createCommand(String action) {

        switch (action) {
//            case "addBook":
//                return new addBookCommand();
//            case "buybook":
//                return new buyBookCommand();
//            case "changePassword":
//                return new changePasswordCommand();
//            case "findBook":
//                return new findBookCommand();
           case "login":
                return new loginCommand();
            case "register":
                return new registerCommand();
//           case "checkUsername":
//              return new checkUsernameCommand();
//            case "changePasswordExp":
//                return new changePassExpCommand();
//            case "bookList2":
//                return new bookList2Command();
//            case "bookList3":
//                return new bookList3Command();
//            case "deleteMember":
//                return new deleteMemberCommand();
//            case "changeDetails":
//                return new editDetailsCommand();
            default:
                break;
        }
        return null;
    }
}