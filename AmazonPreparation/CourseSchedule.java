// 38/46 cases passed

import java.util.*;

class Solution {
    
    private boolean shouldBeAddedToVisited(HashMap<Integer, ArrayList<Integer>> prerequisitesReferenceMap, int currentCourse, HashSet<Integer> visited){
        ArrayList<Integer> prerequisites = prerequisitesReferenceMap.getOrDefault(currentCourse, new ArrayList<Integer>());
        
        for(Integer prerequisite: prerequisites){
            if(!visited.contains(prerequisite)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean canFinishDFS(HashMap<Integer, ArrayList<Integer>> prerequisitesReferenceMap, HashMap<Integer, ArrayList<Integer>> nextCoursesReferenceMap, int currentCourse, HashSet<Integer> visited){
        
        boolean isVisited = shouldBeAddedToVisited(nextCoursesReferenceMap, currentCourse, visited);
        
        if(isVisited){
            visited.add(currentCourse);
            
            ArrayList<Integer> nextCourses = 
                prerequisitesReferenceMap.getOrDefault(currentCourse, new ArrayList<Integer>());
            
            for(Integer nextCourse: nextCourses){
                if(visited.contains(nextCourse)) {
                    return false;
                }
                
                boolean coursesArePossible = 
                    canFinishDFS(
                        prerequisitesReferenceMap, 
                        nextCoursesReferenceMap, 
                        nextCourse, 
                        visited
                    );
                
                if(!coursesArePossible){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private HashMap<Integer, ArrayList<Integer>> createReferenceMap(int[][] prerequisites, boolean isPrerequisites) {
        HashMap<Integer, ArrayList<Integer>> referenceMap = new HashMap();
        int numOfPrerequisites = prerequisites.length;
        
        for(int i=0; i<numOfPrerequisites; i++){
            int prerequisite = isPrerequisites?prerequisites[i][0]:prerequisites[i][1];
            int nextCourse = isPrerequisites?prerequisites[i][1]:prerequisites[i][0];
            if(referenceMap.containsKey(prerequisite)){
                referenceMap.get(prerequisite).add(nextCourse);
            } else {
                referenceMap.put(prerequisite, new ArrayList(Arrays.asList(nextCourse)));
            }
        }
        
        return referenceMap;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> prerequisitesReferenceMap = createReferenceMap(prerequisites, true);
        HashMap<Integer, ArrayList<Integer>> nextCoursesReferenceMap = createReferenceMap(prerequisites, false);
        
        HashSet<Integer> visited = new HashSet();
        
        for(int currentCourse=0; currentCourse<numCourses; currentCourse++){
            if(!canFinishDFS(prerequisitesReferenceMap, nextCoursesReferenceMap, currentCourse, visited)){
                return false;
            } 
        }
        
        for(int currentCourse=0; currentCourse<numCourses; currentCourse++){
            if(!visited.contains(currentCourse) && (prerequisitesReferenceMap.containsKey(currentCourse))){
                return false;
            }
        }
        
        return true;
    }
    
}
