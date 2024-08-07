package leetcode.backtracking.combinations;

import java.util.*;

public class WordLadderii126New {

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> res = new ArrayList<>();
    // 因为需要快速判断扩展出的单词是否在 wordList 里，因此需要将 wordList 存入哈希表，这里命名为「字典」
    Set<String> dict = new HashSet<>(wordList);
    // 特殊用例判断
    if (!dict.contains(endWord)) {
      return res;
    }

    dict.remove(beginWord);

    // 第 1 步：广度优先搜索建图
    // 记录扩展出的单词是在第几次扩展的时候得到的，key：单词，value：在广度优先搜索的第几层
    Map<String, Integer> steps = new HashMap<String, Integer>();
    steps.put(beginWord, 0);
    // 记录了单词是从哪些单词扩展而来，key：单词，value：单词列表，这些单词可以变换到 key ，它们是一对多关系
    Map<String, List<String>> from = new HashMap<String, List<String>>();
    int step = 1;
    boolean found = false;
    int wordLen = beginWord.length();
    Queue<String> queue = new ArrayDeque<String>();
    queue.offer(beginWord);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String currWord = queue.poll();
        char[] charArray = currWord.toCharArray();
        // 将每一位替换成 26 个小写英文字母
        for (int j = 0; j < wordLen; j++) {
          char origin = charArray[j];
          for (char c = 'a'; c <= 'z'; c++) {
            charArray[j] = c;
            String nextWord = String.valueOf(charArray);
            if (steps.containsKey(nextWord) && step == steps.get(nextWord)) {
              from.get(nextWord).add(currWord);
            }
            if (!dict.contains(nextWord)) {
              continue;
            }
            // 如果从一个单词扩展出来的单词以前遍历过，距离一定更远，为了避免搜索到已经遍历到，且距离更远的单词，需要将它从 dict 中删除
            dict.remove(nextWord);
            // 这一层扩展出的单词进入队列
            queue.offer(nextWord);

            // 记录 nextWord 从 currWord 而来
            from.putIfAbsent(nextWord, new ArrayList<>());
            from.get(nextWord).add(currWord);
            // 记录 nextWord 的 step
            steps.put(nextWord, step);
            if (nextWord.equals(endWord)) {
              found = true;
            }
          }
          charArray[j] = origin;
        }
      }
      step++;
      if (found) {
        break;
      }
    }

    // 第 2 步：回溯找到所有解，从 endWord 恢复到 beginWord ，所以每次尝试操作 path 列表的头部
    if (found) {
      Deque<String> path = new ArrayDeque<>();
      path.add(endWord);
      backtrack(from, path, beginWord, endWord, res);
    }
    return res;
  }

  public void backtrack(Map<String, List<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> res) {
    if (cur.equals(beginWord)) {
      res.add(new ArrayList<>(path));
      return;
    }
    for (String precursor : from.get(cur)) {
      path.addFirst(precursor);
      backtrack(from, path, beginWord, precursor, res);
      path.removeFirst();
    }
  }

  public static void main(String[] args) {
    WordLadderii126New ins = new WordLadderii126New();
    List<String> wordList = new ArrayList<String>();

//    String[] ArrayString =  {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
//    for(int i = 0; i < ArrayString.length; i++){
//      wordList.add(ArrayString[i]);
//    }
    wordList.add("hot");
    wordList.add("dot");
    wordList.add("dog");
    wordList.add("lot");
    wordList.add("log");
    wordList.add("cog");
//    List<List<String>> result = ins.findLadders("qa","sq",wordList);
    List<List<String>> result = ins.findLadders("hit","cog",wordList);
    result.forEach(x -> System.out.println(x));
  }
}
