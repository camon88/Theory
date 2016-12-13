/* Does your calculator obey the precedence rules you are
 * accustomed to with C++?
 *
 * Yes it does obey normal mathemathical precedence rules
 * that a user of the calculator would be accustomed to.
 *
 *
 * If so, what is it about the grammar that allows it to 
 * work that way? If not, what could you do to the grammar
 * to make your calculator obey the precedence rules?
 *
 * The way the grammar is designed allows it follow normal
 * precedence rules. It comes up with solutions piece by
 * piece from the bottom up. Once it gets up to Term it 
 * first multiplys or divides and stores the solution. Then
 * it goes up to Expr and adds/subtracts to/from the 
 * solution. It uses recursion in an itelligent way that 
 * allows for operator precedence to still be followed. 
 *
 */

#include <iostream>
#include <cctype>
#include <cstdlib>

using namespace std;

void match(char lookahead , char& curr);
void error();
void White(char& curr);
double Expr(char& curr);
double Term(char& curr);
double Factor(char& curr);
double RealNum(char& curr);
void White(char& curr);


int main ()
{
    double result;
    char curr;
    cout << "Enter an expression: ";
    cin.get(curr);
    result = Expr(curr);
    if (curr == '\n')
        cout << "Expression evaluates to " << result << endl;
        else
            error();
        return 0;
}

void White(char& curr)
{
    while (curr == ' ')
    {
        match(' ', curr);
    }
    while (curr == '\t')
    {
        match('\t', curr);
    }

}

void error()
{
    cout << "syntax error" << endl;
    exit(1);
}


double Expr (char& curr)
{
    bool negative = false;
    double result;
    White(curr);
    if (curr == '+' || curr == '-')
    {
         White(curr);
         if (curr == '-')
         {
             White(curr);
             negative = true;
         }
         match(curr,curr);
    }
    result = Term(curr);
    White(curr);
    if (negative) result = -result;
    while (curr == '+' || curr == '-')
    {
        White(curr);
        if (curr == '+')
        {
            White(curr);
            match ('+', curr);
            result = result + Term(curr);
            White(curr);
        }
        else
        {
            White(curr);
            match ('-', curr);
            result = result - Term(curr);
            White(curr);
        }
    }
    return result;
   
}

double Factor(char& curr) 
{
    White(curr);
    double result;
    if (curr == '+' || curr == '-' || isdigit(curr))
    {
        White(curr);
        result = RealNum(curr);
        White(curr);
    }
    else if (curr == '(')
    {
        White(curr);
        match('(', curr);
        result = Expr(curr);
        match(')', curr);
        White(curr);
    }
    else 
    {
        error();
    }
    return result;
    White(curr);
}

double Term(char& curr)
{
    White(curr);
    double result;
    result = Factor(curr);
    while (curr == '*' || curr == '/')
    {   White(curr);
        if (curr == '*')
        {
            White(curr);
            match ('*', curr);
            result = result * Factor(curr);
            White(curr);
        }
        else 
        {
            White(curr);
            match ('/', curr);
            result = result / Factor(curr);
            White(curr);
        }
    }
    return result;
} 

double RealNum(char& curr)
{
    double result;
    cin.unget();
    cin >> result;
    cin.get(curr); // need to get the next lookahead char.
    return result;
}

void match(char lookahead, char& curr)
{
    if (curr == lookahead)
        cin.get(curr);
    else error();
}


