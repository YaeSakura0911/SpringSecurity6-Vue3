import { ref } from 'vue'
import { defineStore } from "pinia";

export const useUserStore = defineStore('user', () => {
    const name = ref(0)
    const permissions = ref([])

    /**
     * 判断是否有指定权限
     * @param permission 权限
     * @returns Boolean
     */
    function hasPermission(permission) {
        return permissions.value.includes(permission)
    }

    return {name, permissions, hasPermission}
})