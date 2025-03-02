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
        <img width="110px" alt="image" src="https://github.com/user-attachments/assets/aa3639ea-d2a7-4473-9708-9fa2b51aeeb4" />
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
    <div style="text-align:center"><img width="674" alt="image" src="https://github.com/user-attachments/assets/5d06afa8-275b-48d5-912b-1c7e8aa05323" /></div>
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
        <img width="150" src="https://github.com/user-attachments/assets/c92aabec-3fbc-4714-bb2d-5526e12b1d98" />
    <br>
    정리) * <strong>k명만 뽑은 순서 없는 조합의 경우의 수</strong>
        1. 분자: n!로 n명 중 k명을 뽑는 모든 경우를 계산
        2. 첫 번째 나누기: (n - k)!로 남은 사람은 제거
        3. 두 번째 나누기: k!로 중복된 순서를 제거
</pre>
<ul>
    <li>파스칼의 삼각형</li>
    <div style="text-align:center;"><img width="300" alt="image" src="https://github.com/user-attachments/assets/eda5af3e-41bc-41f0-93f7-15dc1bb5ac4c" /></div>
    <div style="display:none;text-align:center;"><img width="150" alt="image" src="https://github.com/user-attachments/assets/4679c010-8930-4fb4-a988-a301b5600d26" /></div>
</ul>
<pre>
    <img width="200" src="https://github.com/user-attachments/assets/ddf3420a-b121-4e4a-a531-e0c3882e592b" />
    <br>
    <span>nCr의 이항계수는 아래와 같이 표현할 수 있다.</span>
    <img style="margin-top:5px;" width="150" src="https://github.com/user-attachments/assets/ba1a9c06-6079-4a34-8c2c-5421cd5acd6e" />
    <br>
    <span>n과 r이 같거나 r이 0이라면 1이다.</span>
</pre>
<br>
<br>
<h3># DFS(Depth-First Search, 깊이 우선 탐색)</h3>
<ul>
    <li>DFS</li>
</ul>
<pre>
    <img width="400" src="https://github.com/user-attachments/assets/1b919395-e4c5-4c2f-bd68-0b60000757f0" />
    <br>
    <span>1) 시작 노드를 스택에 넣고 방문 표시</span>
    <span>2) 스택에서 노드를 하나 꺼내어 그 노드의 인접한 노드를 모두 스택에 넣고 방문 표시</span>
    <span>3) 더 이상 방문할 노드가 없을 때까지 이 과정을 반복</span>
    <br>
    <span><strong>DFS 특징</strong></span>
    <span>- 깊이 우선</span>
    <span>- 스택(Stack) 사용</span>
    <span>- 모든 경로를 탐색 (최단 경로에 적합하지 않음)</span>
    <span>- 재귀적으로 탐색</span>
    <span>- 백트래킹을 사용할 때 유용</span>
    <br/>
    <span><strong>DFS 응용</strong></span>
    <span>- 경로 찾기(미로 탐색)</span>
    <span>- 위상 정렬</span>
    <span>- 연결 요소 찾기</span>
    <span>- 사이클감지</span>
    <span>- 백트래킹</span>
    <span>- BFS에 비해 적은 메모리 사용</span>
</pre>
<br>
<br>
<h3># BFS(Breadth-First Search, 너비 우선 탐색)</h3>
<ul>
    <li>BFS</li>
</ul>
<pre>
    <img width="400" src="https://github.com/user-attachments/assets/c33a3dbf-576e-4321-a532-c2effa9a922b" />
    <br>
    <span>1) 시작 노드를 큐에 넣고 방문 표시</span>
    <span>2) 큐에서 노드를 하나 꺼내어 해당 노드와 인접한 노드를 모두 큐에 넣고 방문 표시</span>
    <span>3) 큐가 빌 때까지 이 과정을 반복</span>
    <br>
    <span><strong>BFS 특징</strong></span>
    <span>- 너비 우선</span>
    <span>- 큐(Queue) 사용</span>
    <span>- 최단경로</span>
    <span>- 레벨 순서 탐색</span>
    <span>- DFS보다 더 많은 메모리를 사용</span>
    <br/>
    <span><strong>BFS 응용</strong></span>
    <span>- 두 노드 사이의 최단 경로 찾기</span>
    <span>- 연결 요소 찾기</span>
    <span>- 네트워크 분석</span>
    <span>- 웹크롤링</span>
    <span>- 퍼즐 게임 해결</span>
</pre>