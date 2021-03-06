package co.unicauca.microkernel.business;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
import co.unicauca.microkernel.plugin.manager.PluginManager;

public class DeliveryService {

    public double calculateDeliveryCost(Delivery deliveryData) throws Exception {

        String countryCode = deliveryData.getCountryCode();
        PluginManager manager = PluginManager.getInstance();
        IDeliveryPlugin plugin = manager.getDeliveryPlugin(countryCode);

        if (plugin == null) {
            throw new Exception("No hay un plugin disponible para el país indicado: " + countryCode);
        }

        return plugin.calculateCost(deliveryData);

    }

}
