# Baekjoon

<br>
<h3># 소수</h3>
<ul>
    <li>에라토스테네스의 체(Eratosthenes' sieve) 알고리즘</li>
</ul>
<pre>
    1) 모든 수를 소수로 가정 (0, 1은 제외)
    2) i의 배수들은 소수가 아님을 표시
    3) i가 √N(n의 제곱근)보다 작거나 같을 때까지 반복
    <span style='background-color:#ffdce0'><strong>(어떤 수의 약수는 그 수의 제곱근 이하에 존재하기 때문이다.)</strong></span>
    <br>
    <span><strong>시간복잡도: O(NloglogN)</strong></span>
</pre>
<br>
<br>
<h3># 방정식</h3>
<ul>
    <li>크래머의 법칙</li>
    <span>(여러 개의 선형 방정식이 있을 때 해를 구하는 방법)</span>
</ul>
<pre>
    1) 연립 방정식: 두 개의 방정식이 있다고 가정
        2x + 3y = 8
        4x - y = 2
    <br>
    2) 행렬로 표현
        <img style="margin-top:5px;" width="110px" alt="image" src="https://github.com/user-attachments/assets/aa3639ea-d2a7-4473-9708-9fa2b51aeeb4" />
    <br>
    3) x와 y 구하기
        D = (2 x -1) - (4 x 3) = -14
        <br>
        Dx = (8 x -1) - (2 x 3) = -14
        x = Dx / D = -14 / -14 = 1
        <br>
        Dy = (2 x 2) - (4 x 8) = -28
        y = Dy / D = -28 / -14 = 2
        <br>
        <strong>해는 x = 1, y = 2</strong>
</pre>
<br>
<br>
<h3># 최소공배수와 최대공약수</h3>
<ul>
    <li>유클리드 호제법</li>
    <span></span>
</ul>
<pre>
</pre>
<br>
<br>
<h3># 이항계수</h3>
<ul>
    <li>이항계수</li>
    <span><img width="674" alt="image" src="https://github.com/user-attachments/assets/5d06afa8-275b-48d5-912b-1c7e8aa05323" /></span>
</ul>
<pre>
    이항계수(또는 이항 계수, Binomial Coefficient)는 주어진 두 정수 n과 k에 대해, n개의 항목 중에서 k개를 선택하는 방법의 수를 나타낸다.
    이는 조합(combination)의 개념과 동일하다.
    <br>
    1) 전체 경우의 수를 계산 (순서를 고려할 경우)
        n x (n - 1) x (n - 2) x ··· x (n - k + 1)
        즉, n명 중에 첫 번째 사람을 뽑은 경우는 n, 두 번째 사람은 n - 1, ... 이런 식으로 경우가 줄어들게 된다.
        팩토리얼을 이용하면 아래와 같다.
        <span><img width="45px" alt="image" src="https://github.com/user-attachments/assets/0181d328-a177-41ca-a274-f5ece685fd0b" /></span>
        n!은 전체 n개의 팩토리얼이고, 뒤에 남는 (n - k)!는 나눠서 제거한 것이다.
    <br>
    2) 중복 제거 (순서를 고려하지 않을 경우)
    k명을 뽑을 때 순서를 고려하지 않는다면, 중복된 경우를 제거해야 한다.
    예를 들어, A와 B를 뽑을 때 A → B와 B → A는 같은 경우이기 때문이다.
    순서를 고려한 경우는 k!개가 있다.
    즉, k명을 뽑는 순서의 모든 조합을 제거하려면 나누기 k!를 해야한다.
    <br>
    
```math
\binom{n}{k} = \frac{n!}{k!(n-k)!}
```
</pre>
