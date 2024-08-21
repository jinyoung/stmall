<template>

    <v-data-table
        :headers="headers"
        :items="getPhoneNumberById"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'GetPhoneNumberByIdView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            getPhoneNumberById : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/getPhoneNumberByIds'))

            temp.data._embedded.getPhoneNumberByIds.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.getPhoneNumberById = temp.data._embedded.getPhoneNumberByIds;
        },
        methods: {
        }
    }
</script>

