#include <vector>
#define FOR(i, n) for (int i = 0; i < (n); ++i)

using namespace std;

// int main()
// {
bool hasDuplicate(const vector<int> &array)
{
    for (int i = 0; i < array.size(); ++i)
        for (int j = 0; j < i; ++j)
            if (array[i] == array[j])
                return true;
    return false;
}

bool hasDuplicateMacro(const vector<int> &array)
{
    FOR(i, array.size())
    FOR(j, i)
    if (array[i] == array[j])
        return true;
    return false;
}
// }
