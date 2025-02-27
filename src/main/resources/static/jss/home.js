   document.addEventListener('DOMContentLoaded', function () {
        const alertElements = document.querySelectorAll('.alert');
        alertElements.forEach(alert => {
            setTimeout(() => {
                alert.style.transition = 'opacity 1s';
                alert.style.opacity = '0';
            }, 3000);
            setTimeout(() => {
                alert.style.display = 'none';
            }, 4000);
        });
    });

