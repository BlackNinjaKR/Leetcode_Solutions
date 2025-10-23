/*
Shunting yard algorithm approach:
1. Split the Infix expression and read from left to right
2. While the token is a number add it to output
3. If the token is an operator:
    i> If the stack contains an operator of high or equal precedence operator, pop from stack to output
    ii> Push to stack
4. If token is '(' push to stack
5. If token is ')':
    i> Pop from stack to output until '(' is found
    ii> Discard the '('
6. After reading all tokens pop remaining operators in stack to output
*/
#include<iostream>
#include<cstring>
#include<vector>
#include<sstream>
#include<cctype>
#include<stack>
using namespace std;

vector<string> split(const string& str)
{
    vector<string> tokens;
    string num;
    for (size_t i = 0; i < str.size(); ++i) {
        char c = str[i];
        if (isspace((unsigned char)c)) continue;
        // numbers (with optional decimal point)
        if (isdigit((unsigned char)c) || c == '.') {
            num.clear();
            bool seenDot = (c == '.');
            if (c == '.') num += '.'; else num += c;
            ++i;
            while (i < str.size() && (isdigit((unsigned char)str[i]) || str[i] == '.')) {
                if (str[i] == '.') {
                    if (seenDot) break; // stop at second dot; let validation catch malformed numbers
                    seenDot = true;
                }
                num += str[i];
                ++i;
            }
            --i;
            tokens.push_back(num);
        }
        // identifiers (variables): letters followed by letters/digits/_
        else if (isalpha((unsigned char)c)) {
            string id;
            id += c;
            ++i;
            while (i < str.size() && (isalnum((unsigned char)str[i]) || str[i] == '_')) {
                id += str[i];
                ++i;
            }
            --i;
            tokens.push_back(id);
        } else {
            // operator or parenthesis
            tokens.push_back(string(1, c));
        }
    }
    return tokens;
}

// Returns true if token is a well-formed decimal/integer number
bool isNumber(const string &tok)
{
    if (tok.empty()) return false;
    int dots = 0;
    for (size_t i = 0; i < tok.size(); ++i) {
        char c = tok[i];
        if (c == '.') {
            dots++; if (dots > 1) return false;
            // '.' alone is not a valid number
            if (tok.size() == 1) return false;
        } else if (!isdigit((unsigned char)c)) return false;
    }
    return true;
}

// Returns true if token is an identifier (variable name)
bool isIdentifier(const string &tok)
{
    if (tok.empty()) return false;
    if (!isalpha((unsigned char)tok[0])) return false;
    for (size_t i = 1; i < tok.size(); ++i)
        if (!(isalnum((unsigned char)tok[i]) || tok[i] == '_')) return false;
    return true;
}

// Operand is either a number or an identifier
bool isOperand(const string &tok)
{
    return isNumber(tok) || isIdentifier(tok);
}


// Use std::stack<char> instead of a custom Stack implementation

class Infix2Postfix
{
    public:
        string expValidate(const vector<string>& tokens);
        int precedence(const string &op);
        bool isRightAssociative(const string &op);
        bool isOperator(const string &s);
};

string Infix2Postfix::expValidate(const vector<string>& tokens)
{
    int parenCount = 0;
    string prev = "";

    for (size_t idx = 0; idx < tokens.size(); ++idx)
    {
        const string &tok = tokens[idx];

        if (tok == "(") {
            parenCount++;
            if (!prev.empty() && (isOperand(prev) || prev == ")")) return "Token '(' cannot follow an operand or ')'.";
        }
        else if (tok == ")") {
            parenCount--;
            if (parenCount < 0) return "Unmatched closing parenthesis.";
            if (prev.empty() || isOperator(prev) || prev == "(") return "')' cannot follow an operator or be at start.";
        }
        else if (isOperator(tok)) {
            // unary +/− allowed if at start or after '(' or after another operator
            if ((idx == 0 || prev == "(" || isOperator(prev)) && (tok == "+" || tok == "-")) {
                // unary operator should be followed by a number, identifier or '('
                if (idx + 1 >= tokens.size()) return "Expression cannot end with unary operator.";
                const string &next = tokens[idx+1];
                if (!(next == "(" || isOperand(next))) return string("Unary operator '" + tok + "' must be followed by a number, identifier or '('.");
            } else {
                // binary operator; prev must be an operand or ')'
                if (prev.empty() || isOperator(prev) || prev == "(") return string("Binary operator '" + tok + "' in invalid position.");
            }
        }
        else {
            // operand (number or identifier)
            if (!isOperand(tok)) return string("Invalid token: '") + tok + "'.";
            if (!prev.empty() && prev == ")") return "Missing operator between ')' and operand.";
        }

        prev = tok;
    }

    if (!tokens.empty()) {
        const string &last = tokens.back();
        if (isOperator(last) && last != "+" && last != "-") return "Expression cannot end with binary operator.";
        if (last == "(") return "Unmatched opening parenthesis.";
    }

    if (parenCount != 0) return "Mismatched parentheses.";
    return string(); // empty = OK
}

bool Infix2Postfix::isOperator(const string &s)
{
    return s == "+" || s == "-" || s == "*" || s == "/" || s == "^" || s == "%";
}

bool Infix2Postfix::isRightAssociative(const string &op)
{
    return op == "^" || op == "u"; // 'u' is unary minus, right-associative
}

int Infix2Postfix::precedence(const string &op)
{
    if (op == "u") return 5; // unary minus highest precedence
    if (op == "^") return 4;
    if (op == "*" || op == "/" || op == "%") return 3;
    if (op == "+" || op == "-") return 2;
    return 0;
}

int main()
{
    std::stack<char> obj;
    string line;
    cout << "Enter your infix expression: ";
    getline(cin, line);

    vector<string> tokens = split(line);

    Infix2Postfix conv;
    string err = conv.expValidate(tokens);
    if (!err.empty())
    {
        cout<<"Invalid expression: "<<err<<endl;
        return 1;
    }

    // Convert to postfix using tokens
    vector<string> output;

    for (size_t j = 0; j < tokens.size(); ++j)
    {
        const string &token = tokens[j];

        if (isOperand(token))
        {
            output.push_back(token);
            continue;
        }

        if (token == "(")
        {
            obj.push('(');
            continue;
        }

        if (token == ")")
        {
            while (!obj.empty() && obj.top() != '(')
            {
                char topc = obj.top();
                string outOp = (topc == 'u') ? string("-") : string(1, topc);
                output.push_back(outOp);
                obj.pop();
            }
            if (!obj.empty()) obj.pop(); // pop '('
            continue;
        }

        // token is an operator
        string oper = token;
        if ((token == "+" || token == "-") && (j == 0 || tokens[j-1] == "(" || conv.isOperator(tokens[j-1])))
        {
            // unary operator
            if (token == "+") {
                // unary plus: no-op (skip pushing an operator)
                continue;
            } else {
                // unary minus: emit a 0 operand and use 'u' on the operator stack
                output.push_back("0");
                oper = "u"; // represent unary minus as 'u'
            }
        }

        while (!obj.empty())
        {
            char topc = obj.top();
            string topStr(1, topc);
            int ptop = conv.precedence(topStr);
            int pcur = conv.precedence(oper);
            if (ptop > pcur || (ptop == pcur && !conv.isRightAssociative(oper)))
            {
                string outOp = (topc == 'u') ? string("-") : string(1, topc);
                output.push_back(outOp);
                obj.pop();
            }
            else break;
        }

        // push current operator (for 'u' or standard operators)
        obj.push(oper[0]);
    }

    while (!obj.empty())
    {
        char topc = obj.top();
        string outOp = (topc == 'u') ? string("-") : string(1, topc);
        output.push_back(outOp);
        obj.pop();
    }

    // join output with spaces
    string postfix;
    for (size_t k = 0; k < output.size(); ++k)
    {
        if (k) postfix += ' ';
        postfix += output[k];
    }

    cout<<"Postfix expression: "<<postfix<< endl;

    return 0;
}