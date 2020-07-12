
class KotlinFunDeclForm {
    String id;
    String funParam;
    String type;
    String funBody = "";
    boolean assn = false;

    public void setAssn(boolean b){
        assn = b;
    }

    public void setId(String s){
        id = s;
    }

    public void setFunParam(String s){
        funParam = s;
    }

    public void setType(String s){
        type = s;
    }

    public void setFunBody(String s){
        funBody = s;
    }

    public String makeStr(){
        String out = "";

        if(id.equals("main"))
            return "public static void main(String[] args)" + funBody;

        if(type.equals("void") && assn) {
            if(assn) out = "Object ";
        }
        else out = type + " ";

        out += (id + funParam + reLine());

        return "static " + out;
    }

    private String reLine(){
        funBody = funBody.replace("(\n)+", "\n");
        return funBody;
    }

}