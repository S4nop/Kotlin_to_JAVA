
public class KotlinUtils{
    public static String cngType(String orgType){
        if(orgType.contains("?")) orgType = orgType.replace("?", "");
        if(orgType.equals("Any")) return "Object";
        if(orgType.equals("Int")) return "Integer";
        return orgType;
    }

    public static String chkType(String chk){

        if(chk.contains("listOf(")){
            String chker;
            if(chk.contains(",")) chker = chk.split(",")[0].split("\\(")[1];
            else chker = chk.split("\\(")[1].split("\\)")[0];
            return chkDetail(chker) + "[]";

        }
    
        return chkDetail(chk);
		
    }


    public static String chkDetail(String chk){
        if(chk.contains("\"")) return "String";
        else {
            if(chk.contains(".")){
                try{
                    Double.parseDouble(chk);
                    return "Double";
                } catch(Exception e){}
            }
        }
        return "Integer";
    }

    public static String cngListOf(String chk){

        chk = chk.replace("listOf(", "{");
        chk = chk.substring(0, chk.length() - 1) + "}";
        return chk;
        
    }

}