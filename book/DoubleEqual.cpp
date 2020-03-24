#include <iostream>

using namespace std;

double fabs(double a);

// 절대 오차와 상대 오차를 모두 이용해서 두 수가 같은지 판정합니다.
bool doubleEqual(double a, double b) {
    double diff = fabs(a - b);

    // 절대 오차가 허용 범위 안일 경우 무조건 true를 반환합니다.
    if (diff < 1e-10) return true;

    // 이 외의 경우에는 상대 오차를 사용합니다.
    return diff <= 1e-8 * max(fabs(a), fabs(b));
}