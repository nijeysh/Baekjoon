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
        (2   3 )  (x)       (8)
                        =
        (4   -1)  (y)       (2)
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
    <span></span>
</ul>
<pre>
</pre>