function memoize(fn) {
    const root = new Map();

    return function (...args) {
        let node = root;

        for (let arg of args) {
            if (!node.has(arg)) {
                node.set(arg, new Map());
            }
            node = node.get(arg);
        }

        // special key for result
        if (node.has("result")) {
            return node.get("result");
        }

        const result = fn(...args);
        node.set("result", result);

        return result;
    };
}