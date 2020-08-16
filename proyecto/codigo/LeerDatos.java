public class LeerDatos {
    File file = new File("0_test_balanced_5000.csv");
                try{
        Scanner input = new Scanner(file);
        String line;
        while (input.hasNextLine()) {
            line = input.nextLine();
            String[] arrOfLine = line.split(",");
            for (String element : arrOfLine) {
                System.out.println(element);
            }
        }
    } catch(
    Exception e){
        System.out.println(e.getMessage());
    }
}
