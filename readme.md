
# 
<center>
  <h2>Yan Kudashov (SE-2432)</h2>
<h3>Bonus Task</h3>
</center>

---


##
### 1. **LPS Array Construction**

The LPS array stores, for each index of the pattern, the length of the longest proper prefix that is also a suffix.
This allows the search phase to skip unnecessary character checks after a mismatch.

### 2. **Pattern Search**

The algorithm scans the text only once.
When characters match, both indices move forward.
When a mismatch occurs, the algorithm uses the LPS array to determine how far the pattern should shift, instead of restarting from the beginning.

---

## Time and Space Complexity

### **Time Complexity**

* **Building the LPS array:** O(M)
* **Searching in the text:** O(N)

Where:

* *N* = length of the text
* *M* = length of the pattern

**Total Time Complexity:**
`O(N+M)`

### **Space Complexity**

The only additional data structure is the LPS array of size *M*.

**Total Space Complexity:**
`O(M)`

---

## Test Data


### **1. Short string**

```
Text:    AAAAABABAAAABAA
Pattern: ABA
```

### **2. Middle string**

```
Text:    ABCXABCABHHYABCABCX
Pattern: ABCX
```

### **3. Long string**

```
Text:    AAAAAAABBBBAAAAAAAAAAAAAAABAAAAAABBAAAA
Pattern: AAAAB
```


---

