if ('serviceWorker' in navigator) {
    window.addEventListener('load', function () {
        navigator.serviceWorker.register('./sw.js', {scope: '/pwa/'})
            .then(function (registration) {
                // 注册成功
				alert(1)
                console.log('ServiceWorker registration successful with scope: ', registration.scope);
            })
            .catch(function (err) {
                // 注册失败:(
				alert(2)
                console.log('ServiceWorker registration failed: ', err);
            });
    });
}