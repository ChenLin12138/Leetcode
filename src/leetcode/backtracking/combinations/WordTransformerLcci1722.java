package leetcode.backtracking.combinations;

import java.util.*;

public class WordTransformerLcci1722 {
    Map<String, Set<String>> toMap = new HashMap<>();
    List<String> result = new ArrayList<>();
    List<String> subResult = new ArrayList<>();
    Map<String,Integer> steps = new HashMap<>();
    int level = 0;
    boolean stop = false;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        bfs(beginWord,endWord,wordList);
        if(null != toMap){
            backTracking(beginWord, endWord);
        }
        //toMap里面其实表达的是一个树形结构，我们现在需要解析这个树形结构的全路径，这其实是一个dfs,也可以理解为一个回溯
        return result;
    }
    private void backTracking(String currentNode, String endWord){
        //退出条件
        if(endWord.equals(currentNode)){
            subResult.add(currentNode);
            result = new ArrayList<>(subResult);
            subResult.remove(currentNode);
            return;
        }
        Set<String> nextNodes = toMap.get(currentNode);
        if(null != nextNodes){
            for(String nextNode : nextNodes){
                //选取
                subResult.add(currentNode);
                //回溯
                backTracking(nextNode,endWord);
                //清理
                subResult.remove(currentNode);
            }
        }
    }

    private int bfs(String beginWord, String endWord, List<String> wordList){
        //不用Set就要超时
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
            return 0;

        int levelResult = 0;
        Deque<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while(!queue.isEmpty() && !stop){
            level ++;
            int levelCount = queue.size();
            for(int i =0; i < levelCount; i ++){
                String curNode = queue.remove();
                if(curNode.equals(endWord)){
                    stop = true;
                    levelResult = level;
                }
                wordSet.remove(curNode);
                List<String> nextLevelNodes = findNextWords(curNode, wordSet);
                for(String node : nextLevelNodes){
                    queue.add(node);
                    if(toMap.containsKey(curNode)){
                        toMap.get(curNode).add(node);
                    }else {
                        Set<String> set = new HashSet<>();
                        set.add(node);
                        toMap.put(curNode,set);
                    }
                }
            }
        }
        return levelResult;
    }

    //替换成一个26n的复杂度运算
    private List<String> findNextWords(String word, Set<String> wordSet){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < word.length(); i ++){
            for(char c = 'a'; c <= 'z'; c++){
                String newString = word.substring(0,i) + c + word.substring(i+1);
                //查询最短路劲层，是否还有其他可行的路径
                if(steps.containsKey(newString) && steps.get(newString) == level){
                    result.add(newString);
                }

                if(wordSet.contains(newString)){
                    steps.put(newString,level);
                    result.add(newString);
                    wordSet.remove(newString);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
