/**
 * @param {number[]} nums
 * @param {number} lower
 * @param {number} upper
 * @return {string[]}
 */
var findMissingRanges = function(nums, lower, upper) {
  var result = [];
  var start = lower;
  for (let num of nums) {
    if (num < lower) { continue; }
    if (num > upper) { break; }
    if (num === start) {
      ++start;
    } else {      
      if (num === start + 1) {
        result.push(start.toString());
        start = num + 1;
      } else if (start < num - 1) {        
        result.push(start.toString() + '->' + (num - 1).toString());
        start = num + 1;
      }
    }
  }
  if (start <= upper) {
    if (upper === start) {
      result.push(upper.toString());
    } else {
      result.push(start.toString() + '->' + upper.toString());
    }
  }
  return result;
};