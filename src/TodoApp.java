import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    public static void main(String[] args) throws Exception {
        ArrayList<String> todoList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("TodoList를 실행하였습니다.");
        System.out.println("명령어는 조회, 추가, 완료, 종료가 있습니다.");
        while(true) {
            System.out.println("명령어를 입력해주세요.");
            String command = scanner.nextLine();
            System.out.println(command);
            if(command.equals("조회")) {
                showList(todoList);
            }
            else if(command.equals("추가")) {
                addList(scanner,todoList);
            }else if(command.equals("완료")) {
                finishList(scanner, todoList);
            }else if(command.equals("종료")) {
                break;
            }else {
                System.out.println("올바른 명령어가 아닙니다.");
            }
        }
    }

    public static void addList(Scanner scanner,ArrayList<String> array) {
        System.out.println("추가할 작업을 입력하세요");
        String list =  scanner.nextLine();
        array.add(list);
        System.out.println("추가가 완료되었습니다");
    }

    public static void showList(ArrayList<String> array) {
        if(array.size() == 0 ) {
            System.out.println("할 일 목록이 비어있습니다.");
        }else {
            for(int i = 0 ; i < array.size() ; i++) {
                System.out.println((i+1)+". " + array.get(i));
            }
        }
    }
    public static void finishList(Scanner scanner, ArrayList<String> array) {
        System.out.println("완료한 작업의 번호를 선택하세요");
        showList(array);
        int idx = scanner.nextInt();
        array.remove(idx);
        System.out.println("완료처리하였습니다.");
    }
}