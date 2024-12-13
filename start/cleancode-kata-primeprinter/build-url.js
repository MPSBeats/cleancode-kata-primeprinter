function buildUrl(url, options) {
    if (url === null) {
        return '';
    }

    if (typeof url === 'object') {
        options = url;
        url = '';
    }

    let builtUrl = url || '';
    builtUrl += buildPath(options);
    builtUrl += buildQueryString(options);
    builtUrl += buildHash(options);

    return builtUrl;
}

function buildPath(options) {
    if (options && options.path) {
        builtUrl += '/' + options.path;
        return builtUrl;
    }
    return '';
}

function buildQueryString(options) {
    if (options && options.queryParams) {
        for (key in options.queryParams) {
            if (options.queryParams.hasOwnProperty(key)) {
                queryString.push(key + '=' + options.queryParams[key]);
            }
        }
        builtUrl += '?' + queryString.join('&');
        return builtUrl;
    }
    return '';
}

function buildHash(options) {
    if (options && options.hash) {
        builtUrl += '#' + options.hash;
        return builtUrl;
    }
    return '';
}