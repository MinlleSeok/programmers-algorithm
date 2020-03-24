#include <vector>

using namespace std;

// 주어진 배열 A에서 가장 많이 등장하는 숫자를 반환합니다.
// 만약 두 가지 이상 있을 경우 아무것이나 반환합니다.
int majority1(const vector<int>& A) {
    int N = A.size();
    int majority = -1, majorityCount = 0;
    
    for (int i = 0; i < N; ++i) {
        // A에 등장하는 A[i]의 수를 셉니다.
        int V = A[i], count = 0;
        for (int j = 0; j < N; ++j) {
            if (A[j] == V) {
                ++count;
            }
        }

        // 지금까지 본 최대 빈도보다 많이 출현했다면 답을 갱신합니다.
        if (count > majorityCount) {
            majorityCount = count;
            majority = v;
        }
    }
    return majority;
}

// A의 각 원소가 0부터 100사이의 값일 경우 가장 많이 등장하는 숫자를 반환합니다.
int majority2(const vector<int>& A) {
    int N = A.size();
    vector<int> count(101, 0);

    for (int i = 0; i < N; ++i) {
        count[A[i]]++;
    }

    // 지금까지 확인한 숫자 중 빈도수가 제일 큰 것을 majority에 저장합니다.
    int majority = 0;

    for (int i = 1; i <= 100; ++i) {
        if (count[i] > count[majority]) {
            majority = i;
        }
    }
    return majority;
}