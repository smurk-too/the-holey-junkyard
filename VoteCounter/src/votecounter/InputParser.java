package votecounter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.jdom2.*;
import org.jdom2.input.*;

/**
 *
 * @author shardul
 */
public class InputParser {

    private static List<String> groups;
    private static List<String> genericPosts;
    private static String[][] genericNominees;
    private static List<String> nonGenericPosts;
    private static String[][][] nonGenericNominees;
    
    public static List<String> getGroups() {
        return groups;
    }

    public static String[][] getGenericNominees() {
        return genericNominees;
    }

    public static String[][][] getNonGenericNominees() {
        return nonGenericNominees;
    }

    public static List<String> getGenericPosts() {
        return genericPosts;
    }

    public static List<String> getNonGenericPosts() {
        return nonGenericPosts;
    }
    
    public static void parse(java.io.InputStream is) throws JDOMException, IOException {
        Element root = ((new SAXBuilder()).build(is)).getRootElement();
        int listSize;
        
        List<Element> groupList = root.getChild("groups").getChildren();
        String[] groupArray = new String[groupList.size()];
        for (int i = 0; i < groupList.size(); i++) {
            groupArray[i] = groupList.get(i).getText();
        }
        groups = Arrays.asList(groupArray);
        
        List<Element> genericPostList = root.getChild("posts").getChild("generic").getChildren();
        listSize = genericPostList.size();
        List<Element> nominees;
        String[] genericPostArray = new String[listSize];
        genericNominees = new String[listSize][];
        for (int i = 0; i < listSize; i++) {
            genericPostArray[i] = genericPostList.get(i).getAttributeValue("name");
            nominees = genericPostList.get(i).getChildren();
            genericNominees[i] = new String[nominees.size()];
            for (int j = 0; j < nominees.size(); j++) {
                genericNominees[i][j] = nominees.get(j).getText();
            }
        }
        genericPosts = Arrays.asList(genericPostArray);
        
        // you better document this stuff NOW
        // or else it'll work, but no-one will know HOW
        
        List<Element> nonGenericPostList = root.getChild("posts").getChild("nongeneric").getChildren();
        listSize = nonGenericPostList.size();
        List<Element> competingGroups;
        List<Element> groupNominees;
        String[] nonGenericPostArray = new String[listSize];
        nonGenericNominees = new String[listSize][][];
        for (int i = 0; i < listSize; i++) {
            nonGenericPostArray[i] = nonGenericPostList.get(i).getAttributeValue("name");
            competingGroups = nonGenericPostList.get(i).getChildren();
            nonGenericNominees[i] = new String[groups.size()][];
            int group;
            for (int j = 0; j < competingGroups.size(); j++) {
                group = groups.indexOf(competingGroups.get(j).getAttribute("name").getValue());
                groupNominees = competingGroups.get(j).getChildren();
                nonGenericNominees[i][group] = new String[groupNominees.size()];
                for (int k = 0; k < groupNominees.size(); k++) {
                    nonGenericNominees[i][group][k] = groupNominees.get(k).getText();
                }
            }
        }
        nonGenericPosts = Arrays.asList(nonGenericPostArray);
    }
}
