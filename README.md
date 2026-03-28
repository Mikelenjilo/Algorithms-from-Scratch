# Algorithms From Scratch

A growing collection of classic algorithms implemented from scratch in Kotlin. Each entry includes a runnable example and brief notes on behavior and complexity. The current entry point is `src/Main.kt`.

## Algorithms

### Binary Search (implemented)
- Operates on a sorted array with two pointers (`left`, `right`) bracketing the search range.
- Repeatedly checks the middle index `mid = (left + right) / 2`; if the middle value is greater than the target, it discards the right half, if less, it discards the left half. This halves the search space each step.
- Stops when the target is found (returns its index) or the range is exhausted (returns `-1`).
- **Complexity**: 
  - **time**: $O(log \times n)$ because the range halves on each iteration;
  - **space**: $O(1)$ because only a few index variables are tracked.