export const isRouteForLoggedUser = ():boolean => {
    return isRouteForAdmin() || isRouteForUser();
}

export const isRouteForAdmin = (): boolean => {
    const route = useRoute()
    const routeName = route.name as string;

    if (routeName === 'admin-login') {
        return false;
    }

    return routeName!.split('-')[0] === 'admin';
}

export const isRouteForUser = (): boolean => {
    const route = useRoute()
    const routeName = route.name as string;

    return routeName!.split('-')[0] === 'user';
}