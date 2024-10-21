# Baekjoon

<br>
<h3># 소수</h3>
에라토스테네스의 체(Eratosthenes' sieve) 알고리즘
<pre>
    1) 모든 수를 소수로 가정 (0, 1은 제외)
    2) i의 배수들은 소수가 아님을 표시
    3) i가 √N(n의 제곱근)보다 작거나 같을 때까지 반복
    <span style='background-color:#ffdce0'><strong>(어떤 수의 약수는 그 수의 제곱근 이하에 존재하기 때문이다.)</strong></span>
    <br>
    <span><strong>시간복잡도: O(NloglogN)</strong></span>
</pre>

<br>
