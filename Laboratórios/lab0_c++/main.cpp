#include <iostream>
#include <fstream>
#include <string>
using namespace std;
int main()
{
    cout << "\nCONVERTOR PARA HTML" << endl;
    cout << "Resultado do texto convertido do arquivo entrada.txt:" << endl << endl;

    ifstream file("entrada.txt");

    if (!file)
    {
        cerr << "Não foi possível abrir o arquivo" << endl;
        return -1;
    }

    char ch;
    bool primAsterisco, primUnderLine = false;

    while (file.get(ch))
    {
        if (ch == '*')
        {
            if (primAsterisco == false)
            {
                cout << "<b>";
                primAsterisco = true;
                continue;
            }
            if (primAsterisco == true)
            {
                cout << "</b>";
                primAsterisco = false;
                continue;
            }
        }

        if (ch == '_')
        {
            if (primUnderLine == false)
            {
                cout << "<i>";
                primUnderLine = true;
                continue;
            }
            if (primUnderLine == true)
            {
                cout << "</i>";
                primUnderLine = false;
                continue;
            }
        }
        cout << ch;
    }
    cout << endl << endl;
    file.close();
}
