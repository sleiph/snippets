local list = {}
list.ArrayList = {}
list.ArrayList.__index = list.ArrayList

local MinPQ = {}
MinPQ.__index = MinPQ

local UnionFind = {}
UnionFind.__index = UnionFind

local KruskalMST = {}
KruskalMST.__index = KruskalMST

local graph = {}
graph.__index = graph
graph.Edge = {}
graph.Edge.__index = graph.Edge

-- criando uma lista
function list.ArrayList.create()
    local s = {}
    setmetatable(s, list.ArrayList)

    s.a = { nil }
    s.aLen = 1
    s.N = 0
    return s
end

function list.create()
    return list.ArrayList.create()
end

function list.ArrayList:add(value)
    self.a[self.N] = value
    self.N = self.N + 1
    if self.N == self.aLen then
        self:resize(self.aLen * 2)
    end
end

function list.ArrayList:get(index)
    local temp = self.a[index]
    return temp
end

function list.ArrayList:indexOf(value)
    if self.N == 0 then
        return -1
    end
    for i=0,self.N-1 do
        if self.a[i] == value then
            return i
        end
    end
    return -1
end

function list.ArrayList:contains(value)
    return self:indexOf(value) ~= -1
end

function list.ArrayList:resize(newSize)
    local temp = {}
    for i = 0,(newSize-1) do
        temp[i] = self.a[i]
    end

    self.a = temp
    self.aLen = newSize
end

function list.ArrayList:size()
    return self.N
end

-- MinPQ
function MinPQ.create(comparator)
    local s = {}
    setmetatable(s, MinPQ)

    if comparator == nil then
        comparator = function(a1, a2) return a1 - a2 end
    end


    s.a = {}
    s.N = 0
    s.comparator = comparator
    return s
end

function MinPQ:add(item)
    self.N = self.N + 1
    self.a[self.N] = item

    self:swim(self.N)
end

function MinPQ:delMin()
    if self.N == 0 then
        return nil
    end

    local item = self.a[1]

    self:exchange(self.a, 1, self.N)
    self.N = self.N - 1
    self:sink(1)

    return item
end

function MinPQ:sink(k)
    while k * 2 <= self.N do
        local child = k * 2
        if child < self.N and self:less(self.a[child+1], self.a[child]) then
            child = child + 1
        end
        if self:less(self.a[child], self.a[k]) then
            self:exchange(self.a, child, k)
            k = child
        else
            break
        end
    end
end

function MinPQ:isEmpty()
    return self.N == 0
end

function MinPQ:swim(k)
    while k > 1 do
        local parent = math.floor(k / 2)
        if self:less(self.a[k], self.a[parent]) then
            self:exchange(self.a, k, parent)
        else
            break
        end
    end
end

function MinPQ:less(a1, a2)
    return self.comparator(a1, a2) < 0
end

function MinPQ:exchange(a, i, j)
    local temp = a[i]
    a[i] = a[j]
    a[j] = temp
end

-- estrutura de união-busca
function UnionFind.createFromVertexList(vertices)
    local s = {}
    setmetatable(s, UnionFind)

    s.id = {}
    s.count = {}
    for i=0, vertices:size()-1 do
        local v = vertices:get(i)
        s.id[v] = v
        s.count[v] = 1
    end
    return s
end

function UnionFind:root(v)
    local x = v
    while self.id[x] ~= x do
        x = self.id[x]
        self.id[x] = self.id[self.id[x]]
    end
    return x
end

function UnionFind:union(v, w)
    local v_root = self:root(v)
    local w_root = self:root(w)

    if v_root ~= w_root then
        if self.count[v_root] > self.count[w_root] then
            self.id[w_root] = v_root
            self.count[v_root] = self.count[w_root] + self.count[v_root]
        else
            self.id[v_root] = w_root
            self.count[w_root] = self.count[w_root] + self.count[v_root]
        end
    end

end

function UnionFind:connected(v, w)
    return self:root(v) == self:root(w)
end

-- algoritmo de Kruskal
function KruskalMST.create()
    local s = {}
    setmetatable(s, KruskalMST)

    s.marked = {}
    s.path = list.create()
    return s
end

function KruskalMST:run(G)
    self.marked = {}
    self.path = list.create()
    local pq = MinPQ.create(function(e1, e2)
        return e1.weight - e2.weight
    end)

    for i = 0, G:vertexCount()-1 do
        local v = G:vertexAt(i)
        self.marked[v] = false
    end

    local edges = G:edges()
    for i = 0, edges:size()-1 do
        local e = edges:get(i)
        pq:add(e)
    end

    local uf = UnionFind.createFromVertexList(G:vertices())
    while pq:isEmpty() == false and self.path:size() < G:vertexCount() - 1 do
        local e = pq:delMin()
        local v = e:either()
        local w = e:other(v)
        if uf:connected(w, v) == false then
            uf:union(w, v)
            self.path:add(e)
        end
    end
end

-- criando o grafo
function graph.Edge.create(v, w, weight)
    local s = {}
    setmetatable(s, graph.Edge)

    if weight == nil then
        weight = 1.0
    end

    s.v = v
    s.w = w
    s.weight = weight

    return s
end

function graph.Edge:from()
    return self.v
end

function graph.Edge:to()
    return self.w;
end

function graph.Edge:either()
    return self.v
end

function graph.Edge:other(x)
    if x == self.v then
        return self.w
    else
        return self.v
    end

end

function graph.create(V, directed)
    local g = {}
    setmetatable(g, graph)

    if directed == nil then
        directed = false
    end

    g.vertexList = list.create()
    g.adjList = {}
    for v = 0,V-1 do
        g.vertexList:add(v)
        g.adjList[v] = list.create()
    end
    g.directed = directed

    return g
end

function graph:vertexCount()
    return self.vertexList:size()
end

function graph:vertices()
    return self.vertexList
end

function graph:addVertexIfNotExists(v)
    if self.vertexList:contains(v) then
        return false
    else
        self.vertexList:add(v)
        self.adjList[v] = list.create()
        return true
    end
end

function graph:adj(v)
    return self.adjList[v]
end

function graph:addEdge(v, w, weight)
    local e = graph.Edge.create(v, w, weight)
    self:addVertexIfNotExists(v)
    self:addVertexIfNotExists(w)
    if self.directed then
        self.adjList[e:from()]:add(e)
    else
        self.adjList[e:from()]:add(e)
        self.adjList[e:to()]:add(e)
    end

end

function graph:vertexAt(i)
    return self.vertexList:get(i)
end

function graph:edges()
    local list = list.create()

    for i=0,self.vertexList:size()-1 do
        local v = self.vertexList:get(i)
        local adj_v = self:adj(v)
        for i=0,adj_v:size()-1 do
            local e = adj_v:get(i)
            local w = e:other(v)
            if self.directed == true or w > v then
                list:add(e)
            end

        end

    end

    return list
end

-- executando o programa
print("Digite o número de vertices e arestas do grafo, separados por espaço: 'V E'")
entrada = io.read()
pedacos = {}
for substring in entrada:gmatch("%S+") do
    table.insert(pedacos, tonumber(substring))
end
    
local mst = KruskalMST.create()
local grafo = graph.create(pedacos[1])

print("Digite as coordenadas e peso das " .. pedacos[2] .. " arestas originais do grafo, separados por espaço: 'x y w'")
for i = 1, pedacos[2] do
    entrada = io.read()
    pedacos = {}
    for substring in entrada:gmatch("%S+") do
        table.insert(pedacos, tonumber(substring))
    end
    grafo:addEdge(pedacos[1], pedacos[2], pedacos[3])
end
    
mst:run(grafo)
local path = mst.path

print("De acordo com o algoritmo de Kruskal, o grafo mínimo possível é:")
for i=0,path:size()-1 do
    local e = path:get(i)
    print(e:from() .. ' -> ' .. e:to() .. ' (' .. e.weight .. ')')
end