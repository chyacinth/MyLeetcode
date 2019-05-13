class Solution {
    private class HelperResult {
        public Integer val = 0;
        public int nextPos = 0;        
        public String variable = "";
    }
    
    private HelperResult evaluateHelper(String expression, Map<String, Integer> values, int st) {
        HelperResult result = new HelperResult();
        if (Character.isDigit(expression.charAt(st)) || expression.charAt(st) == '-') {            
            int i = st;
            int sign = 1;
            if (expression.charAt(st) == '-') {                
                ++i;
            }
            while (Character.isDigit(expression.charAt(i))) {
                ++i;
            }
            result.nextPos = i;
            result.val = Integer.valueOf(expression.substring(st, i));            
        } else if (expression.charAt(st) == '(') {
            if (expression.startsWith("let ", st + 1)) {
                Map<String, Integer> oldValues = new HashMap<>();
                int i = st + 5;
                HelperResult variableResult = evaluateHelper(expression, values, i);                
                while (expression.charAt(variableResult.nextPos) == ' ') {
                    HelperResult expResult = evaluateHelper(expression, values, variableResult.nextPos + 1);
                    oldValues.put(variableResult.variable, values.get(variableResult.variable));
                    values.put(variableResult.variable, expResult.val);
                    variableResult = evaluateHelper(expression, values, expResult.nextPos + 1);                    
                }
                oldValues.forEach(values::put);
                result = variableResult;
                ++result.nextPos;
            } else if (expression.startsWith("mult ", st + 1)) {
                HelperResult e1Result = evaluateHelper(expression, values, st + 6);
                HelperResult e2Result = evaluateHelper(expression, values, e1Result.nextPos + 1);
                result.val = e1Result.val * e2Result.val;
                result.nextPos = e2Result.nextPos + 1;
            } else if (expression.startsWith("add ", st + 1)) {
                HelperResult e1Result = evaluateHelper(expression, values, st + 5);
                HelperResult e2Result = evaluateHelper(expression, values, e1Result.nextPos + 1);                
                result.val = e1Result.val + e2Result.val;
                result.nextPos = e2Result.nextPos + 1;
            }
        } else {            
            StringBuilder variableSb = new StringBuilder();
            int i = st;
            variableSb.append(expression.charAt(i));
            while (Character.isLetterOrDigit(expression.charAt(i))) {
                variableSb.append(expression.charAt(i));
                ++i;
            }
            result.nextPos = i;
            result.variable = variableSb.toString();            
            result.val = values.get(result.variable);            
        }
        return result;
    }
    
    public int evaluate(String expression) {
        Map<String, Integer> values = new HashMap<>();
        return evaluateHelper(expression, values, 0).val;
    }
}