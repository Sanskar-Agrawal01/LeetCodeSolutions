📚 720. Longest Word in Dictionary
Difficulty: Medium
Topics: Trie, HashSet, Sorting
Companies: [Available in LeetCode Premium]

🧠 Problem Statement
You are given an array of strings words representing an English dictionary.

Your task is to return the longest word in words that can be built one character at a time by other words in the list.

If there is more than one valid answer, return the smallest lexicographical one.
If no such word exists, return an empty string.

A word is considered buildable if:

It is constructed left to right, and

Each prefix of the word is also in the dictionary.

🧾 Input
words: An array of strings

Constraints
1 <= words.length <= 1000

1 <= words[i].length <= 30

Each words[i] consists of lowercase English letters only

✅ Output
Return the longest buildable word following the given rules.

🔍 Examples
Example 1
vbnet
Copy
Edit
Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation:
"world" can be built using "w" → "wo" → "wor" → "worl" → "world".

Example 2
vbnet
Copy
Edit
Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation:
Both "apple" and "apply" are valid. "apple" is lexicographically smaller.

💡 Approach
You can solve this problem using either of the following methods:

✅ Option 1: HashSet + Sorting
Sort the list so that shorter words come first.

For each word, check if all its prefixes exist in a Set.

Track the longest valid word.

✅ Option 2: Trie
Insert all words into a Trie.

Traverse the Trie in DFS, only following paths where each prefix is a word.

Track the deepest valid word with lexicographic ordering.