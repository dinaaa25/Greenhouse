<template>
  <div>
    <Disclosure as="nav" class="bg-emerald-600" v-slot="{ open }">
      <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div class="flex h-16 items-center justify-between">
          <div class="flex items-center">
            <div class="flex-shrink-0">
              <img class="h-8 w-8" src="/logo.png" alt="Your Company" />
            </div>
            <div class="hidden md:block">
              <div class="ml-10 flex items-baseline space-x-4">
                <NuxtLink v-for="item in navigation" :key="item.name" :href="item.href"
                  :class="[isCurrent(item) ? 'bg-emerald-700 text-white' : 'text-white hover:bg-emerald-500 hover:bg-opacity-75', 'rounded-md px-3 py-2 text-sm font-medium']"
                  :aria-current="isCurrent(item) ? 'page' : undefined">{{ item.name }}</NuxtLink>
              </div>
            </div>
          </div>
          <div class="hidden md:block">
            <div class="ml-4 flex items-center md:ml-6">
              <button type="button"
                class="relative rounded-full bg-emerald-600 p-1 text-emerald-200 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-emerald-600">
                <span class="absolute -inset-1.5" />
                <span class="sr-only">View notifications</span>
                <Icon name="ph:bell" class="h-6 w-6" aria-hidden="true" />
              </button>

              <!-- Profile dropdown -->
              <Menu as="div" class="relative ml-3">
                <div>
                  <MenuButton
                    class="relative flex max-w-xs items-center rounded-full bg-emerald-600 text-sm focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-emerald-600">
                    <span class="absolute -inset-1.5" />
                    <span class="sr-only">Open user menu</span>
                    <img class="h-8 w-8 rounded-full" :src="user.imageUrl" alt="" />
                  </MenuButton>
                </div>
                <transition enter-active-class="transition ease-out duration-100"
                  enter-from-class="transform opacity-0 scale-95" enter-to-class="transform opacity-100 scale-100"
                  leave-active-class="transition ease-in duration-75" leave-from-class="transform opacity-100 scale-100"
                  leave-to-class="transform opacity-0 scale-95">
                  <MenuItems
                    class="absolute right-0 z-10 mt-2 w-48 origin-top-right rounded-md bg-white py-1 shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none">
                    <MenuItem v-for="item in userNavigation" :key="item.name" v-slot="{ active }">
                    <NuxtLink :href="item.href"
                      :class="[active ? 'bg-gray-100' : '', 'block px-4 py-2 text-sm text-gray-700']">{{ item.name
                      }}</NuxtLink>
                    </MenuItem>
                  </MenuItems>
                </transition>
              </Menu>
            </div>
          </div>
          <div class="-mr-2 flex md:hidden">
            <!-- Mobile menu button -->
            <DisclosureButton
              class="relative inline-flex items-center justify-center rounded-md bg-emerald-600 p-2 text-emerald-200 hover:bg-emerald-500 hover:bg-opacity-75 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-emerald-600">
              <span class="absolute -inset-0.5" />
              <span class="sr-only">Open main menu</span>
              <Icon name="ph:line-segments" v-if="!open" class="block h-6 w-6" aria-hidden="true" />
              <Icon name="ph:x-bold" v-else class="block h-6 w-6" aria-hidden="true" />
            </DisclosureButton>
          </div>
        </div>
      </div>

      <DisclosurePanel class="md:hidden">
        <div class="space-y-1 px-2 pb-3 pt-2 sm:px-3">
          <DisclosureButton v-for="item in navigation" :key="item.name" as="a" :href="item.href"
            :class="[isCurrent(item.current) ? 'bg-emerald-700 text-white' : 'text-white hover:bg-emerald-500 hover:bg-opacity-75', 'block rounded-md px-3 py-2 text-base font-medium']"
            :aria-current="isCurrent(item) ? 'page' : undefined">{{ item.name }}</DisclosureButton>
        </div>
        <div class="border-t border-emerald-700 pb-3 pt-4">
          <div class="flex items-center px-5">
            <div class="flex-shrink-0">
              <img class="h-10 w-10 rounded-full" :src="user.imageUrl" alt="" />
            </div>
            <div class="ml-3">
              <div class="text-base font-medium text-white">{{ user.name }}</div>
              <div class="text-sm font-medium text-emerald-300">{{ user.email }}</div>
            </div>
            <button type="button"
              class="relative ml-auto flex-shrink-0 rounded-full bg-emerald-600 p-1 text-emerald-200 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-emerald-600">
              <span class="absolute -inset-1.5" />
              <span class="sr-only">View notifications</span>
              <Icon name="ph:bell" class="h-6 w-6" aria-hidden="true" />
            </button>
          </div>
          <div class="mt-3 space-y-1 px-2">
            <DisclosureButton v-for="item in userNavigation" :key="item.name" as="a" :href="item.href"
              class="block rounded-md px-3 py-2 text-base font-medium text-white hover:bg-emerald-500 hover:bg-opacity-75">
              {{ item.name }}</DisclosureButton>
          </div>
        </div>
      </DisclosurePanel>
    </Disclosure>
    <NavigationHeader :text="currentNavItem" />
  </div>
</template>

<script setup lang="ts">
import { Disclosure, DisclosureButton, DisclosurePanel, Menu, MenuButton, MenuItem, MenuItems } from '@headlessui/vue';

const route = useRoute();

function isCurrent(navItem: any) {
  return route.path == navItem.href;
}

const currentNavItem = computed(() => {
  let result;
  for (let i = 0; i < navigation.length; i++) {
    if (navigation[i].href === route.path) {
      result = navigation[i].name;
    }
  }
  return result;
});

const user = {
  name: 'Tom Cook',
  email: 'tom@example.com',
  imageUrl:
    'https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80',
}
const navigation = [
  { name: 'Dashboard', href: '/', current: true },
  { name: 'Admin', href: '/admin', current: false },
  { name: 'Dev', href: '/dev', current: false }
];

const userNavigation = [
  { name: 'Your Profile', href: '#' },
  { name: 'Settings', href: '#' },
  { name: 'Sign out', href: '#' },
];
</script>