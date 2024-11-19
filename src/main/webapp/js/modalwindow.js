function openUserEditModal(id, name) {
    document.getElementById('editModal').style.display = 'block';
    document.getElementById('userId').value = id;
    document.getElementById('name').value = name;
}

function openUserCreateModal() {
    document.getElementById('createUserModal').style.display = 'block';
}


function openRespondQueryModal(queryId, deviceName, senderLogin, senderId, deviceId, queryType, userMessage) {
    let modalId;

    switch (queryType) {
        case 'Запрос устройства':
            modalId = 'respondGetQueryModal';
            fillModal(modalId, queryId, deviceName, senderLogin, senderId, deviceId, queryType, userMessage);
            break;
        case 'Починить устройство':
            modalId = 'respondRepairQueryModal';
            fillModal(modalId, queryId, deviceName, senderLogin, senderId, deviceId, queryType, userMessage);
            break;
        case 'Отказ от устройства':
            modalId = 'respondReturnQueryModal';
            fillModal(modalId, queryId, deviceName, senderLogin, senderId, deviceId, queryType, userMessage);
            break;
        default:
            console.error('Неизвестный тип запроса: ' + queryType);
            return;
    }

    document.getElementById(modalId).style.display = 'block';
}

function fillModal(modalId, queryId, deviceName, senderLogin, senderId, deviceId, queryType, userMessage) {
    const modal = document.getElementById(modalId);

    if (modalId === 'respondGetQueryModal') {
        modal.querySelector('#getQueryId').value = queryId;
        modal.querySelector('#getSender').textContent = senderLogin;
        modal.querySelector('#getSenderId').value = senderId;
        modal.querySelector('#getDeviceId').value = deviceId;
        modal.querySelector('#getDevice').textContent = deviceName;
        modal.querySelector('#getQueryType').textContent = queryType;
        modal.querySelector('#getUserMessage').textContent = userMessage;
    } else if (modalId === 'respondRepairQueryModal') {
        modal.querySelector('#repairQueryId').value = queryId;
        modal.querySelector('#repairSender').textContent = senderLogin;
        modal.querySelector('#repairSenderId').value = senderId;
        modal.querySelector('#repairDeviceId').value = deviceId;
        modal.querySelector('#repairDevice').textContent = deviceName;
        modal.querySelector('#repairQueryType').textContent = queryType;
        modal.querySelector('#repairUserMessage').textContent = userMessage;
    } else if (modalId === 'respondReturnQueryModal') {
        modal.querySelector('#returnQueryId').value = queryId;
        modal.querySelector('#returnSender').textContent = senderLogin;
        modal.querySelector('#returnSenderId').value = senderId;
        modal.querySelector('#returnDeviceId').value = deviceId;
        modal.querySelector('#returnDevice').textContent = deviceName;
        modal.querySelector('#returnQueryType').textContent = queryType;
        modal.querySelector('#returnUserMessage').textContent = userMessage;
    }
}


function openDeviceCreateModal() {
    document.getElementById('createDeviceModal').style.display = 'block';
}

function openUserQueryModal(userId, deviceId, deviceName, queryType, message) {
    document.getElementById('createQueryModal').style.display = 'block';
    document.getElementById('question').textContent = `${message} ${deviceName}`;
    document.getElementById('deviceId').value = deviceId;
    document.getElementById('userId').value = userId;
    document.getElementById('queryType').value = queryType;
}

function submitForm(modalId, command) {
    const modal = document.getElementById(modalId);
    modal.querySelector('input[name="command"]').value = command;
    modal.querySelector('form').submit();
}

function closeModal(modalId) {
    document.getElementById(modalId).style.display = 'none';
}


window.onclick = function (event) {
    var modals = document.querySelectorAll('.modal');
    modals.forEach(function (modal) {
        if (event.target === modal) {
            modal.style.display = 'none';
        }
    });
};

