class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        // int step = 0;

        // 昨晚刚做完一个类似的，今天就忘记了！
        // 思维误区：一旦有一位不同，马上就要变，但是变完之后不能马上找
        // 比如说，为了满足在dict里的情况，可以a->b->c，变2次

        // 看题解，建模，这是一个无向图，找无向图里两点之间的最短距离！
        // 用BFS！一定要记住BFS的代码模板，且有2点：1. 队列；2. 是否已经访问过

        // 第一步 先把wordList放到哈希表里
        Set<String> hashSet = new HashSet<>(wordList);

        // 第二步 BFS必须要的队列以及记录是否访问过的哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(beginWord);

        // 第三步 开始BFS，且起始步数为1
        int step = 1;
        while(!queue.isEmpty()){ // 模板，关键的一个判断，队列要不为空！
            int curSize = queue.size(); // 因为在循环里面queue是会变的
            for(int i=0; i<curSize;i++){ // 依次遍历queue中的单词
                String curWord = queue.poll(); // 先进先出，拿到最先进队列的第一个单词
                if(changeCurOneStepToEnd(curWord, endWord, queue, visitedSet, hashSet)){ // 如果当前这个单词，只变一个就能到结尾
                    return step + 1;
                }
            }
            step++; // 每走完一种可能的解法，就是走了一步！
        }
        // 如果在上面没有return，说明不得行
        return 0;
    }

    private boolean changeCurOneStepToEnd(String curWord, String endWord, Queue<String> queue, Set<String> visitedSet, Set<String> hashSet){

        // curWord是一定不等于endWord的

        char[] curArr = curWord.toCharArray();
        for(int i=0; i<endWord.length();i++){ // 一位一位来进行比较
            char origChar = curArr[i]; // 记得这个之后要恢复噢！
            for(char k='a';k<='z';k++){ // 其实就只有26个选择！
                if(k==origChar)continue;
                curArr[i] = k;
                String newWord = String.valueOf(curArr);
                if(hashSet.contains(newWord)){ // 变了一位之后在字典里-大前提！（不在字典里的就不用考虑！）
                    if(endWord.equals(newWord)){
                        return true;
                    }
                    if(!visitedSet.contains(newWord)){ // 还没有访问过-可能的一种解法
                        queue.add(newWord);
                        visitedSet.add(newWord);
                    }
                }
            }
            curArr[i] = origChar; // 恢复
        }

        return false; // 不能只靠一步，所以要继续，且step要+1
    }
}