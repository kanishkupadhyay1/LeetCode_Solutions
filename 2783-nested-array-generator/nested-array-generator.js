var inorderTraversal = function(arr) {
    function* dfs(a) {
        for (let el of a) {
            if (Array.isArray(el)) {
                yield* dfs(el);
            } else {
                yield el;
            }
        }
    }
    return dfs(arr);
};