
# 
<center>
  <h2>Yan Kudashov (SE-2432)</h2>
<h3>Bonus Task</h3>
</center>

---

# KMP Algorithm



## 1. Summary of the Implementation

The implementation consists of two main components:

### **1. LPS Array Construction**

A function computes the **Longest Prefix Suffix (LPS)** array for the pattern.
For each index in the pattern, the LPS array stores the length of the longest prefix that is also a suffix.
This preprocessing ensures that during the search phase the algorithm never re-checks characters unnecessarily.

### **2. KMP Search Function**

The search method scans the text and compares it with the pattern:

* When characters match, both pointers move forward.
* When a mismatch occurs, the pattern pointer jumps using the LPS value instead of resetting to zero.
* When the full pattern is matched, the starting index of the match is recorded.


---

## 2. Testing Results

The implementation was tested on three datasets: short, medium, and long strings.
Below are the test inputs used:

### **Test Case 1 - Short String**

```
Text:    AAAAABABAAAABAA
Pattern: ABA
```

**Expected behavior:** Matches occur at all positions where “ABA” appears within overlapping sequences.

### **Test Case 2 - Middle String**

```
Text:    ABCXABCABHHYABCABCX
Pattern: ABCX
```

**Expected behavior:** First and last occurrences of "ABCX" should be detected.

### **Test Case 3 - Long String**

```
Text:    AAAAAAABBBBAAAAAAAAAAAAAAABAAAAAABBAAAA
Pattern: AAAAB
```

**Expected behavior:** Multiple matches inside long repeated sequences of 'A', with correct skipping behavior using LPS.

These test cases confirm that the algorithm:

* Correctly identifies all valid pattern occurrences
* Handles repeated characters efficiently
* Properly skips using the LPS table instead of re-checking characters

---

## 3. Time and Space Complexity Analysis

### **Time Complexity**

* **LPS construction:** O(M)
* **Pattern search:** O(N)

Where
*N* = length of the text,
*M* = length of the pattern.

Because the algorithm never revisits text characters unnecessarily, the total running time is:

**O(N+M)**

This is significantly faster than the naive algorithm, which can degrade to O(N*M).

### **Space Complexity**

The only auxiliary structure used is the LPS array, which has size *M*.

**Total space complexity: O(M)**


