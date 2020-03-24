#include <iostream>
#include <vector>

using namespace std;

bool canCover(double mid);

double minRadiusCover() {
    double minRadius = 0, maxRadius = 10;

    // 반복문 불변식 : canCover(maxRadius) = true
    while(maxRadius - minRadius > 1e-10) {
        double mid = (minRadius + maxRadius) / 2;

        if (canCover(mid))
            maxRadius = mid;
        else
            minRadius = mid;
    }
    return maxRadius;
}

double minRadiusCover(const vector<double>& candidates) {
    int minIndex = -1, maxIndex = candidates.size() - 1;

    // 반복문 불변식 : canCover(maxRadius) = true
    while(minIndex + 1 < maxIndex) {
        int mid = (minIndex + maxIndex) / 2;
        
        if (canCover(candidates[mid]))
            maxIndex = mid;
        else
            minIndex = mid;
    }

    return candidates[maxIndex];
}